package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    @OneToOne(optional = false)
    @JoinColumn(name = "client_id", nullable = false, unique = true)
    private Client client;

    @Column(nullable = false)
    private LocalDate creationDate;

    @OneToMany(mappedBy = "portfolio")
    private List<Security> securities;

    protected Portfolio() {
        this.securities = new ArrayList<>();
    }

    public Portfolio(Client client, LocalDate creationDate, List<Security> securities) {
        this.client = client;
        this.creationDate = creationDate;
        this.securities = (securities == null) ? new ArrayList<>() : securities;
    }

    public Long getPortfolioId() { return portfolioId; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public LocalDate getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDate creationDate) { this.creationDate = creationDate; }

    public List<Security> getSecurities() { return securities; }
    public void setSecurities(List<Security> securities) {
        this.securities = (securities == null) ? new ArrayList<>() : securities;
    }

}
