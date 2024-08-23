package Services;

import Models.PhuongThucThanhToanModel;
import repository.IPhuongThucThanhToanRespository;
import repository.PhuongThucRepository;

import java.util.List;

public class PhuongThucThanhToanService implements IPhuongThucThanhToan{
    private IPhuongThucThanhToanRespository thanhToanRepository = new PhuongThucRepository();
    @Override
    public List<PhuongThucThanhToanModel> getAll() {
        return thanhToanRepository.findAll();
    }
}
