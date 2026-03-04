package com.example.projects.splitwiseClassDiagram.models;

import java.util.List;

public interface PayoutLedgerRepository {
  List<PayoutLedger> saveAll (List<PayoutLedger> payoutLedgers);
}
