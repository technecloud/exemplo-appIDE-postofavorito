package app.dao;

import java.util.List;

import app.entity.Posto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.entity.Abastecimento;

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * Os métodos de create, edit, delete e outros estão abstraídos no JpaRepository
 * 
 * @see org.springframework.data.jpa.repository.JpaRepository
 * 
 * @generated
 */
@Repository("AbastecimentoDAO")
@Transactional(transactionManager = "app-TransactionManager")
public interface AbastecimentoDAO extends JpaRepository<Abastecimento, String> {
  
  /**
   * Obtém a instância de Abastecimento utilizando os identificadores
   * 
   * @param id
   *          Identificador
   * @return Instância relacionada com o filtro indicado
   * @generated
   */
  @Query("SELECT entity FROM Abastecimento entity WHERE entity.id = :id")
  Abastecimento findOne(@Param(value = "id") String id);
  
  /**
   * Remove a instância de Abastecimento utilizando os identificadores
   * 
   * @param id
   *          Identificador
   * @return Quantidade de modificações efetuadas
   * @generated
   */
  @Modifying
  @Query("DELETE FROM Abastecimento entity WHERE entity.id = :id")
  void delete(@Param(value = "id") String id);
  
  @Query("select c from Abastecimento c")
  Page<Abastecimento> list(Pageable pageable);
  



}
=======
  @Query("SELECT entity FROM Abastecimento entity WHERE entity.user.id = :id")
  Page<Abastecimento> findAbastecimentosByUser(@Param(value = "id") String id, Pageable pageable);
  
  @Query("SELECT entity FROM Abastecimento entity WHERE entity.posto.id = :id")
  Page<Abastecimento> findAbastecimentosByPosto(@Param(value = "id") String id, Pageable pageable);
  
  @Query("SELECT entity FROM Abastecimento entity WHERE entity.carro.id = :id")
  Page<Abastecimento> findAbastecimentosByCarro(@Param(value = "id") String id, Pageable pageable);
  
  @Query("select a from Abastecimento a where a.posto.id = :postoId ")
  Page<Abastecimento> listaAbastecimentosPorPosto(@Param(value = "postoId") String postoId, Pageable pageable);
  
  @Query("select a from Abastecimento a where a.carro.marca = :marca and a.carro.modelo = :modelo and a.carro.ano= :ano")
  Page<Abastecimento> listaAbastecimentosPorMarcaModeloAno(@Param(value = "marca") String marca,
                                                           @Param(value = "modelo") String modelo,
                                                           @Param(value = "ano") Integer ano, Pageable pageable);
  
  @Query("select a.posto from Abastecimento a")
  List<Posto> recuperaPostosQueTemAbastecimento();
  
  @Query("select distinct a.carro.id from Abastecimento a")
  List<String> recuperaCarrosQueTemAbastecimento();
  
  @Query("select distinct a.carro.marca from Abastecimento a")
  List<String> recuperaMarcasQueTemAbastecimento();
  
  @Query("select distinct a.carro.modelo from Abastecimento a where a.carro.marca= :marca")
  List<String> recuperaModelosQueTemAbastecimento(@Param(value = "marca") String marca);
  
  @Query("select distinct a.carro.ano from Abastecimento a where a.carro.modelo= :modelo")
  List<Integer> recuperaAnosQueTemAbastecimento(@Param(value = "modelo") String modelo);
  
}

