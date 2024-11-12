package com.example.loginproyect.Repositories;

import com.example.loginproyect.DTOS.PresupuestoDto;
import com.example.loginproyect.Models.Presupuesto;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class BudgetRepository {
    private final String mainNameDocument = "presupuesto";
    private final FirebaseFirestore databaseReference;

    public BudgetRepository() {
        databaseReference = FirebaseFirestore.getInstance();
    }

    public void addBudget(Presupuesto budget, OnSuccessListener<DocumentReference> onSuccess, OnFailureListener onFailure) {
        PresupuestoDto mainInsertObject = new PresupuestoDto(
                budget.getNombre(),
                budget.getMonto(),
                budget.isActivo(),
                budget.getUserId() // Agrega el userId al DTO
        );

        databaseReference.collection(mainNameDocument)
                .add(mainInsertObject)
                .addOnSuccessListener(onSuccess)
                .addOnFailureListener(onFailure);
    }

    public void listenForBudgetChanges(EventListener<QuerySnapshot> listener) {
        databaseReference.collection(mainNameDocument)
                .addSnapshotListener(listener);
    }
}