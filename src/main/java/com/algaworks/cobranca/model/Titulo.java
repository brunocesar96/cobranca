package com.algaworks.cobranca.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;


@Entity
public class Titulo {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotEmpty(message="Descrição é obrigatório")
    @Size(max = 60 , message = "A descrição não pode conter mais de 60 caracteres")
    private String descricao;

    //Nao esta salvando hora ou minuto apenas data
    @NotNull(message = "Data de vencimento é obrigatória")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;

    //@NumberFormat(pattern ="#,##0.00")
    @NotNull(message = "Valor não pode ser nulo")
    @DecimalMin(value = "0.01",message = "Valor não pode ser menor que 0,01")
    private double  valor;

    //como String pois nao precisa de confirmação , por String
   @Enumerated(EnumType.STRING)
    private StatusTitulo status;


    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public StatusTitulo getStatus() {
        return status;
    }

    public void setStatus(StatusTitulo status) {
        this.status = status;
    }

    public boolean isPendente(){

        return StatusTitulo.PENDENTE.equals(this.status);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Titulo titulo = (Titulo) o;

        return codigo.equals(titulo.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }

}
