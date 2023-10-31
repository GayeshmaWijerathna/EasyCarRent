package lk.ijse.easycarrent.service.impl;

import lk.ijse.easycarrent.dto.IncomeDTO;
import lk.ijse.easycarrent.repo.IncomeRepo;
import lk.ijse.easycarrent.service.IncomeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class IncomeServiceImpl implements IncomeService {
    @Autowired
    private IncomeRepo incomeService;

    @Override
    public ArrayList<IncomeDTO> dailyIncome() {
        return new ArrayList<IncomeDTO>(incomeService.dailyIncome());
    }

    @Override
    public ArrayList<IncomeDTO> monthlyIncome() {
        return new ArrayList<IncomeDTO>(incomeService.MonthlyIncome());
    }

    @Override
    public ArrayList<IncomeDTO> AnnuallyIncome() {
        return new ArrayList<IncomeDTO>(incomeService.AnnuallyIncome());
    }
}
