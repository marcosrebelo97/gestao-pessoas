package com.gestaopessoa.enderco.Entities.PK;

import com.gestaopessoa.enderco.Entities.Endereco;
import com.gestaopessoa.enderco.Entities.Pessoa;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PessoaEnderecoPK {
    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
}
