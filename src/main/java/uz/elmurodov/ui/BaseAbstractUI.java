package uz.elmurodov.ui;

import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.utils.BaseUtils;
import uz.jl.utils.Color;
import uz.jl.utils.Print;

public abstract class BaseAbstractUI {
    protected void show(ResponseEntity response) {
        if (response.getStatus().equals(200))
            Print.println(Color.GREEN, BaseUtils.withoutNulls().toJson(response.getBody()));
        else
            Print.println(Color.RED,BaseUtils.withNulls().toJson(response.getBody()));
    }

    protected void show(Exception e) {
        Print.println(Color.RED, e.getMessage());
    }
}