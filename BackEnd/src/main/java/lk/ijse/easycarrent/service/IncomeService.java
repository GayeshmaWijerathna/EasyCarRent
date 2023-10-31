package lk.ijse.easycarrent.service;

import lk.ijse.easycarrent.dto.IncomeDTO;

import java.util.ArrayList;

public interface IncomeService {
    ArrayList<IncomeDTO> dailyIncome();
    ArrayList<IncomeDTO> monthlyIncome();
    ArrayList<IncomeDTO> AnnuallyIncome();
}
