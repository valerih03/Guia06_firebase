package com.example.loginproyect.UI.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.loginproyect.Models.Presupuesto;
import com.example.loginproyect.Repositories.BudgetRepository;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class BudgetVM extends ViewModel {
    private BudgetRepository repository;
    private MutableLiveData<List<Presupuesto>> budgetLiveData;

    public BudgetVM() {
        repository = new BudgetRepository();
        budgetLiveData = new MutableLiveData<>();
        listenForBudgetChanges();
    }

    public void addBudget(Presupuesto mainObject, OnSuccessListener<DocumentReference> onSuccess, OnFailureListener onFailure) {
        repository.addBudget(mainObject, onSuccess, onFailure);
    }

    public LiveData<List<Presupuesto>> getBudgetLiveData() {
        return budgetLiveData;
    }

    private void listenForBudgetChanges() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String userId = user.getUid();
            repository.listenForBudgetChanges((querySnapshot, e) -> {
                if (e != null) {
                    // Handle the error
                    return;
                }
                List<Presupuesto> presupuestos = new ArrayList<>();
                for (QueryDocumentSnapshot document : querySnapshot) {
                    Presupuesto mainObject = document.toObject(Presupuesto.class);
                    if (userId.equals(mainObject.getUserId())) {  // Filtra solo los presupuestos del usuario actual
                        mainObject.setId(document.getId());
                        presupuestos.add(mainObject);
                    }
                }
                budgetLiveData.postValue(presupuestos);
            });
        }
    }
}