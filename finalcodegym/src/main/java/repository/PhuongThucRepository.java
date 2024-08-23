package repository;

import Models.PhuongThucThanhToanModel;

import com.example.thimodule.model.ThanhToan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhuongThucRepository implements IPhuongThucThanhToanRespository{
    private static final String GET_ALL = "select * from HinhThucThanhToan;";
    @Override
    public List<PhuongThucThanhToanModel> findAll() {
        List<PhuongThucThanhToanModel> thanhToanList = new ArrayList<>();
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
                String thanhtoan = resultSet.getString("thanhtoan");
                thanhToanList.add(new PhuongThucThanhToanModel(id, thanhtoan));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return thanhToanList;
    }
    }
}
