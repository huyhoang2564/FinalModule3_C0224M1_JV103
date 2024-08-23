package repository;

import Enity.NhaTro;
import Models.NhaTroModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhaTroRespository implements INhaTroRespository{

    private static final String GET_ALL= "select * from PhongTro1;";
    private static final String GET_ALL_DTO = "select PhongTro1.MaPT, PhongTro1.NameThue, Phone, DateRent,GhiChu, HinhThucThanhToan.HinhThucThanhToan as HinhThucThanhToan from PhongTro1 left join HinhThucThanhToan on HinhThucThanhToan.id = PhongTro1.id;";
    private static final String SAVE = "insert into PhongTro1 (NameThue, Phone,DateRent, GhiChu,id) values (?, ?, ?, ?, ?);";
    private static final String DELETE_BY_ID = "delete from PhongTro1 where MaPT = ?;";
    private static final String FIND_BY_ID = "select * from PhongTro1 where MaPT = ?;";
    private static final String SEARCH_DTO = "select PhongTro1.MaPT , PhongTro1.NameThue, Phone,DateRent, GhiChu, HinhThucThanhToan.HinhThucThanhToan as HinhThucThanhToan from PhongTro1 join HinhThucThanhToan on HinhThucThanhToan.id = PhongTro1.id where PhongTro1.NameThue like concat ('%', ?, '%') and paymenttype.id = ?;";
    @Override
    public List<NhaTroModel> findAll() {
        List<NhaTroModel> phongTroList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DBConnect.getConnectDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phoneNumber");
                String startDate = resultSet.getString("startDate");
                String description = resultSet.getString("description");
                int PaymentType = resultSet.getInt("paymenttype");
                phongTroList.add(new NhaTroModel(id,name, phoneNumber, startDate, PaymentType,description));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phongTroList;
    }

    @Override
    public List<NhaTro> findAllDto() {
        List<NhaTro> phongTroList = new ArrayList<>();
        Connection  connection = null;
        try {
            connection = DBConnect.getConnectDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_DTO);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phoneNumber");
                String startDate = resultSet.getString("startDate");
                String description = resultSet.getString("description");
                String PaymentType = resultSet.getString("paymenttype");
                phongTroList.add(new NhaTro(id, name, phoneNumber, startDate,PaymentType, description ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phongTroList;
    }

    @Override
    public boolean add(NhaTroModel nhaTro) {
        Connection connection = null;
        int rowEffected = 0;
        try {
            connection = DBConnect.getConnectDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE);
            preparedStatement.setString(1, NhaTroModel.getNameThue());
            preparedStatement.setString(2, NhaTroModel.getPhone());
            preparedStatement.setString(3, NhaTroModel.getDateRent());
            preparedStatement.setString(4, NhaTroModel.getGhiChu());
            preparedStatement.setInt(5, NhaTroModel.HinhThucThanhToan());
            rowEffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return rowEffected >0;
    }

    @Override
    public boolean deleteById(int maPT) {
        Connection connection = null;
        int rowEffected = 0;
        try {
            connection = DBConnect.getConnectDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, maPT);
            rowEffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return rowEffected > 0;
    }

    @Override
    public NhaTroModel findById(int maPT) {
        NhaTroModel phongTro = null;
        Connection connection = null;
        try {
            connection = DBConnect.getConnectDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, maPT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phoneNumber");
                String startDate = resultSet.getString("startDate");
                String description = resultSet.getString("description");
                int thanhtoan = resultSet.getInt("paymenttype");
                phongTro = new NhaTroModel(maPT, name, phoneNumber, startDate,thanhtoan,description  );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phongTro;
    }

    @Override
    public List<NhaTro> search(String name, int PhuongThucThanhToan) {
        List<NhaTro> foundPhongTro = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DBConnect.getConnectDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_DTO);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2,PhuongThucThanhToan);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String foundName = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phoneNumber");
                String startDate = resultSet.getString("startDate");
                String description = resultSet.getString("description");
                String foundThanhToan = resultSet.getString("paymenttype");
                foundPhongTro.add(new NhaTro(id, foundName, phoneNumber, startDate, description, foundThanhToan));

            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return foundPhongTro;
    }
}
