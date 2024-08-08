package model;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class Task {

    private Integer id;
    private String usuario;

    @Size(min=10, message="Insira no mínimo 10 caracteres")
    private String descricao;
    private LocalDate dataAlvo;
    private Boolean feito;

    public Task(Integer id, String usuario, String descricao, LocalDate dataAlvo, Boolean feito) {
        super();
        this.id = id;
        this.usuario = usuario;
        this.descricao = descricao;
        this.dataAlvo = dataAlvo;
        this.feito = feito;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void setFeito(Boolean feito) {
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
