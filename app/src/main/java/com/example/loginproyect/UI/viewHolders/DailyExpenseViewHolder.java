package com.example.loginproyect.UI.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginproyect.R;

public class DailyExpenseViewHolder extends RecyclerView.ViewHolder {
    public TextView txvNombreArticulo;
    public TextView txvPrecio;
    public TextView txvCantidad;
    public TextView txvSubtotal;
    public DailyExpenseViewHolder(@NonNull View itemView) {
        super(itemView);
        txvNombreArticulo = itemView.findViewById(R.id.txvNombreGasto);
        txvPrecio = itemView.findViewById(R.id.txvPrecioGasto);
        txvCantidad = itemView.findViewById(R.id.txvCantidadGasto);
        txvSubtotal = itemView.findViewById(R.id.txvSubtotalGasto);
    }
}