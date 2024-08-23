package repository;

import Models.PhuongThucThanhToanModel;

import java.util.List;

public interface IPhuongThucThanhToanRespository {
    public List<PhuongThucThanhToanModel> findAll();
}
