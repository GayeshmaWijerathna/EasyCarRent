package lk.ijse.easycarrent.service;

import lk.ijse.easycarrent.dto.CustomDTO;
import lk.ijse.easycarrent.dto.PaymentDTO;

import java.util.ArrayList;

public interface PaymentService {
   public CustomDTO paymentIdGenerate();
   public void savePayment(PaymentDTO dto, String rentID);
   public ArrayList<PaymentDTO> getAllPayment();
}
