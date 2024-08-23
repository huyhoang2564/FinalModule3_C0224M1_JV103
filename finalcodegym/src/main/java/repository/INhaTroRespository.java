package repository;

import Enity.NhaTro;
import Models.NhaTroModel;

import java.util.List;

public interface INhaTroRespository {
    public List<NhaTroModel> findAll();

    public List<NhaTro> findAllDto();

    public boolean add(NhaTroModel nhaTro);

    public boolean deleteById(int maPT);

    public NhaTroModel findById(int maPT);

    List<NhaTro> search(String name, int PhuongThucThanhToan);
}
