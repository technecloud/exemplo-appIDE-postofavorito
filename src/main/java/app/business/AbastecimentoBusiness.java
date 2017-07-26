package app.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.*;
import app.dao.*;
import app.entity.*;
import org.springframework.data.domain.PageImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Classe que representa a camada de negócios de AbastecimentoBusiness
 * 
 * @generated
 **/
@Service("AbastecimentoBusiness")
public class AbastecimentoBusiness {

  private static final Logger log = LoggerFactory.getLogger(AbastecimentoBusiness.class);


  /**
   * Instância da classe AbastecimentoDAO que faz o acesso ao banco de dados
   * 
   * @generated
   */
  @Autowired
  @Qualifier("AbastecimentoDAO")
  protected AbastecimentoDAO repository;
  
	@Autowired
	@Qualifier("PostoDAO")
	protected PostoDAO postoDAO;
	
	@Autowired
	@Qualifier("UserDAO")
	protected UserDAO userDAO;

  // CRUD

  /**
   * Serviço exposto para novo registro de acordo com a entidade fornecida
   * 
   * @generated
   */
   
  public Abastecimento post(final Abastecimento entity, HttpServletRequest req) throws Exception {
 		// begin-user-code  
 		// end-user-code  
    String username = (String)req.getSession().getAttribute("username");
 
     
     User user = userDAO.userByLogin(username);
     
      entity.setUser(user);
     		
 	  Abastecimento result = repository.save(entity);
 		// begin-user-code
 		// end-user-code
 		return result;
 	}
  /**
   * Serviço exposto para salvar alterações de acordo com a entidade fornecida
   * 
   * @generated
   */
  public Abastecimento put(final Abastecimento entity) throws Exception {
    // begin-user-code  
    // end-user-code
    Abastecimento result = null;
    result = repository.saveAndFlush(entity);
    // begin-user-code
    // end-user-code
    return result;
  }

  /**
   * Serviço exposto para remover a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  public void delete(java.lang.String id) throws Exception {
    // begin-user-code  
    // end-user-code
    Abastecimento entity = this.get(id);
    this.repository.delete(entity);
    // begin-user-code  
    // end-user-code        
  }
  
  /**
   * Serviço exposto para recuperar a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  public Abastecimento get(java.lang.String id) throws Exception {
    // begin-user-code  
    // end-user-code
    Abastecimento result = repository.findOne(id);
    // begin-user-code
    // end-user-code
    return result;
  }

  // CRUD
  
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<Abastecimento> list(Pageable pageable){
    // begin-user-code
    // end-user-code
    Page<Abastecimento> result = repository.list(pageable);
    // begin-user-code
    // end-user-code
    return result;
  }
  
  public Page<Abastecimento> findAbastecimentosByUser(java.lang.String instanceId, Pageable pageable) {
		// begin-user-code
		// end-user-code  
		Page<Abastecimento> result = repository.findAbastecimentosByUser(instanceId, pageable);
		// begin-user-code  
		// end-user-code        
		return result;
	}
	
	public Page<Abastecimento> findAbastecimentosByPosto(java.lang.String instanceId, Pageable pageable) {
 		// begin-user-code
 		// end-user-code  
 	 Page<Abastecimento> result = repository.findAbastecimentosByPosto(instanceId, pageable);
 	// begin-user-code  
 	// end-user-code        
  	 return result;
 	}
 	
 	public Page<Abastecimento> findAbastecimentosByCarro(java.lang.String instanceId, Pageable pageable) {
 		// begin-user-code
 		// end-user-code  
 		Page<Abastecimento> result = repository.findAbastecimentosByCarro(instanceId, pageable);
 		// begin-user-code  
 		// end-user-code        
 		return result;
 	}
 	
 public Page<AbastecimentoVO> listaRanking(Pageable pageable) {
   
    AbastecimentoVO abastecimentoVo;
    ArrayList<AbastecimentoVO> listaMediaDasRentabilidades = new ArrayList<>();
    ArrayList<AbastecimentoVO> listaPostosCampeoes = new ArrayList<>();
    
    List<Abastecimento> abastecimentos = repository.list(pageable).getContent();
 		List<Posto> postos = abastecimentos.stream().map(Abastecimento::getPosto).distinct().collect(Collectors.toList());
 		
 		
 
 		for (Posto posto : postos) {
 			double acm = 0.0;
 			double mediaRentabilidade= 0.0;
 
 			List<Abastecimento> abastecimentosDeUmPosto = abastecimentos.stream()
 					.filter(a -> a.getPosto().equals(posto))
 					.collect(Collectors.toList());
 			
 			
 		  abastecimentoVo = new AbastecimentoVO(posto.getId(), posto.getNome(), mediaRentabilidade, 0.0);

 			listaMediaDasRentabilidades.add(abastecimentoVo);

 		}
 
 		double acmDeMedias = 0.0;
 		for (AbastecimentoVO a : listaMediaDasRentabilidades) {
 			acmDeMedias = acmDeMedias + a.getMediaRentabilidadesPosto();
 		}
 
 		double mediaTotal = acmDeMedias / listaMediaDasRentabilidades.size();
 
 		for (AbastecimentoVO a : listaMediaDasRentabilidades) {
 			a.setMediaRentabilidadeGeral(mediaTotal);
 			if(a.getMediaRentabilidadesPosto() >= mediaTotal){
 			  listaPostosCampeoes.add(a);
 			  
 			}
 		}
 
 	listaPostosCampeoes.sort(Comparator.comparing(AbastecimentoVO::getMediaRentabilidadesPosto));
 		return new PageImpl<>(listaPostosCampeoes);

 }

 
 
 public Page<CarroVO2> listaRankingCarro(Pageable pageable){
   
 	  
     List<String> marcas = repository.recuperaMarcasQueTemAbastecimento();
     Double acm = 0.0;
     Double mediaRentabilidade = 0.0;
     Page<Abastecimento> temp;
     List<CarroVO2> listaMediaDasRentabilidades = new ArrayList<CarroVO2>();
     List<CarroVO2> listaCarrosCampeoes = new ArrayList<CarroVO2>();
     
     CarroVO2 carroVO2;
     
     List<Abastecimento> abastecimentosDeUmaMarcaModeloAno;
     
     Carro carro = null;
     
     for(String m: marcas) {
       List<String> modelos = repository.recuperaModelosQueTemAbastecimento(m);
       
       for(String mo: modelos){
         List<Integer> anos = repository.recuperaAnosQueTemAbastecimento(mo);
         
         for(Integer a: anos){
           
           temp = repository.listaAbastecimentosPorMarcaModeloAno(m, mo, a, pageable);
           abastecimentosDeUmaMarcaModeloAno = temp.getContent();
            
            for (Abastecimento abastecimento : abastecimentosDeUmaMarcaModeloAno) {
 				      acm = acm + (abastecimento.getQuilometragemRodada() / abastecimento.getPrecoPorLitro());
 			      }
 			      
 			      mediaRentabilidade = acm / abastecimentosDeUmaMarcaModeloAno.size();
 			      
 			      carroVO2 = new CarroVO2(m, mo, a, mediaRentabilidade, 0.0);
 			      
 			      listaMediaDasRentabilidades.add(carroVO2);
 			      carroVO2 = null;
 			      acm = 0.0;
 			      mediaRentabilidade = 0.0;
         }
         
  }
  
     }
     
      Double acmDeMedias = 0.0;
 		 for (CarroVO2 c : listaMediaDasRentabilidades) {
 			      acmDeMedias = acmDeMedias + c.getMediaRentabilidadesCarro();
 		  }
 		    
 		Double mediaTotal = acmDeMedias / listaMediaDasRentabilidades.size();
 		for (CarroVO2 ca : listaMediaDasRentabilidades) {
 			   ca.setMediaRentabilidadeGeral(mediaTotal);
 			   if(ca.getMediaRentabilidadesCarro() >= mediaTotal){
 			     listaCarrosCampeoes.add(ca);
 			     
 			   }
 		}
 		
 		
 		
 		Collections.sort(listaCarrosCampeoes, new Comparator<CarroVO2>() {
 			@Override
 			public int compare(CarroVO2 c1, CarroVO2 c2) {
 				return c1.getMediaRentabilidadesCarro().compareTo(c2.getMediaRentabilidadesCarro());
 			}
 		});
 
    final Page<CarroVO2> retorno = new PageImpl<>(listaCarrosCampeoes);
 		
     return retorno;
 }
 
 
 
  
}