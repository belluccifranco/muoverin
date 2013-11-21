package com.vinilo.model;

import java.util.List;

public class Paginacion<K> {

    private long pagActual;
    private long cantRegistrosPagActual;
    private long cantPaginas;
    private long cantRegistrosTotales;
    private List<K> datos;

    public long getPagActual() {
        return pagActual;
    }

    public void setPagActual(long pagActual) {
        this.pagActual = pagActual;
    }

    public long getCantRegistrosPagActual() {
        return cantRegistrosPagActual;
    }

    public void setCantRegistrosPagActual(long cantRegistrosPagActual) {
        this.cantRegistrosPagActual = cantRegistrosPagActual;
    }

    public long getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(long cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public long getCantRegistrosTotales() {
        return cantRegistrosTotales;
    }

    public void setCantRegistrosTotales(long cantRegistrosTotales) {
        this.cantRegistrosTotales = cantRegistrosTotales;
    }

    public List<K> getDatos() {
        return datos;
    }

    public void setDatos(List<K> datos) {
        this.datos = datos;
    }
}
