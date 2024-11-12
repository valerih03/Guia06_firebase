package com.example.loginproyect;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import com.example.loginproyect.Models.Presupuesto;
import com.example.loginproyect.UI.viewModels.BudgetVM;
import com.example.loginproyect.databinding.ActivityAddBudgetBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AddBudget extends BottomSheetDialogFragment {
    private ActivityAddBudgetBinding binding;
    private BudgetVM viewModel;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(BudgetVM.class);
        binding = ActivityAddBudgetBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.btnGuardarPresupuesto.setOnClickListener(v -> {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user != null) {
                String userId = user.getUid();
                Presupuesto mObject = new Presupuesto(
                        binding.edtATitulo.getText().toString(),
                        Double.parseDouble(binding.edtAMonto.getText().toString()),
                        true,
                        userId  // Asigna el UID del usuario
                );
                viewModel.addBudget(
                        mObject,
                        documentReference -> {
                            this.dismiss();
                            Toast.makeText(getContext(), "Guardado correctamente", Toast.LENGTH_SHORT).show();
                        },
                        e -> {
                            Toast.makeText(getContext(), "No se pudo guardar el presupuesto", Toast.LENGTH_SHORT).show();
                        }
                );
            } else {
                Toast.makeText(getContext(), "Error: usuario no autenticado", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}