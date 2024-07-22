package com.verkeerslicht.datastructures;


import com.verkeerslicht.model.Auto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutoNode {
    private Auto auto;
    private AutoNode  next;


    public AutoNode(Auto auto) {
        this.auto = auto;
    }

    }

