package Services;

import Enity.NhaTro;
import Models.NhaTroModel;
import repository.INhaTroRespository;
import repository.NhaTroRespository;

import java.util.List;

public class NhaTroService implements INhaTroService {
    private INhaTroRespository NhaTroRespository = new NhaTroRespository();
    @Override
    public List<NhaTroModel> findAll() {
        return NhaTroRespository.findAll();
    }

    @Override
    public List<NhaTro> findAllDto() {
        return  NhaTroRespository.findAllDto();
    }

    @Override
    public boolean add(NhaTroModel phongTro) {
        return  NhaTroRespository.add(phongTro);
    }

    @Override
    public boolean deleteById(int id) {
        return NhaTroRespository.deleteById(id);
    }

    @Override
    public NhaTroModel findById(int id) {
        return NhaTroRespository.findById(id);
    }

    @Override
    public List<NhaTro> search(String name, int thanhtoan) {
        return NhaTroRespository.search(name, thanhtoan);
    }
}
