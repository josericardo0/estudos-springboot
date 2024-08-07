package model;

import java.time.LocalDate;

public class Task {

    private int id;
    private String usuario;
    private String descricao;
    private LocalDate dataAlvo;
    private boolean feito;

    public Task(int id, String usuario, String descricao, LocalDate dataAlvo, boolean feito) {
        super();
        this.id = id;
        this.usuario = usuario;
        this.descricao = descricao;
        this.dataAlvo = dataAlvo;
        this.feito = feito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAlvo() {
        return dataAlvo;
    }

    public void setDataAlvo(LocalDate dataAlvo) {
        this.dataAlvo = dataAlvo;
    }

    public boolean isFeito() {
        return feito;
    }

    public void setFeito(boolean feito) {
        this.feito = feito;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataAlvo=" + dataAlvo +
                ", feito=" + feito +
                '}';
    }

}
