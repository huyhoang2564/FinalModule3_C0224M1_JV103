package Services;

import Enity.NhaTro;
import Models.NhaTroModel;

import java.util.List;

public interface INhaTroService {
    public List<NhaTroModel> findAll();
    public List<NhaTro> findAllDto();

    public boolean add(NhaTroModel phongTro);

    public boolean deleteById(int id);

    public NhaTroModel findById(int id);


    List<NhaTro> search(String name, int thanhtoan);
}
