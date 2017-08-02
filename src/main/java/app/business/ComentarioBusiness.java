package app.business;

import java.text.SimpleDateFormat;
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

import app.dao.UserDAO;
import app.entity.Comentario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Classe que representa a camada de negócios de ComentarioBusiness
 * 
 * @generated
 **/
@Service("ComentarioBusiness")
public class ComentarioBusiness {

  private static final Logger log = LoggerFactory.getLogger(ComentarioBusiness.class);


  /**
   * Instância da classe ComentarioDAO que faz o acesso ao banco de dados
   * 
   * @generated
   */
  @Autowired
  @Qualifier("ComentarioDAO")
  protected ComentarioDAO repository;
  
  @Autowired
  @Qualifier("UserDAO")
  protected UserDAO userDAO;

  // CRUD

  /**
   * Serviço exposto para novo registro de acordo com a entidade fornecida
   * 
   * @generated
   */
  public Comentario post(final Comentario entity, HttpServletRequest req) throws Exception {
    // begin-user-code  
    // end-user-code  
   String data = "dd/MM/yyyy";
   String hora = "h:mm - a";
 	String data1, hora1;
 	java.util.Date agora = new java.util.Date();;
 		SimpleDateFormat formata = new SimpleDateFormat(data);
 		data1 = formata.format(agora);
 		formata = new SimpleDateFormat(hora);
 		hora1 = formata.format(agora);
 
     
     entity.setData(data1+" "+hora1); 
     
     
     String username = (String)req.getSession().getAttribute("username");
 
     User user = userDAO.userByLogin(username);
     entity.setUser(user);
    
     Comentario result = repository.save(entity);
    // begin-user-code
    // end-user-code
    return result;
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade fornecida
   * 
   * @generated
   */
  public Comentario put(final Comentario entity) throws Exception {
    // begin-user-code  
    // end-user-code
    Comentario result = null;
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
    Comentario entity = this.get(id);
    this.repository.delete(entity);
    // begin-user-code  
    // end-user-code        
  }
  
  /**
   * Serviço exposto para recuperar a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  public Comentario get(java.lang.String id) throws Exception {
    // begin-user-code  
    // end-user-code
    Comentario result = repository.findOne(id);
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
  public Page<Comentario> list(Pageable pageable){
    // begin-user-code
    // end-user-code
    Page<Comentario> result = repository.list(pageable);
    // begin-user-code
    // end-user-code
    return result;
  }
  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  public Page<Comentario> generalSearch(java.lang.String search, Pageable pageable) {
    return repository.generalSearch(search, pageable);
  }
  
  /**
   * Searchable fields - Specific search
   * @generated
   */
  public Page<Comentario> specificSearch(java.lang.String data, java.lang.String texto, java.lang.Boolean moderado, Pageable pageable) {
    return repository.specificSearch(data, texto, moderado, pageable);
  }
  
   public Page<Comentario> findComentariosByUser(java.lang.String instanceId, Pageable pageable) {
     // begin-user-code
     // end-user-code  
     Page<Comentario> result = repository.findComentariosByUser(instanceId, pageable);
     // begin-user-code  
     // end-user-code        
     return result;
   }
   
   /**
    * Foreign Key posto
 -   * @generated
 -   */
   public Page<Comentario> findComentariosByPosto(java.lang.String instanceId, Pageable pageable) {
     // begin-user-code
     // end-user-code  
     Page<Comentario> result = repository.findComentariosByPosto(instanceId, pageable);
     // begin-user-code  
     // end-user-code        
     return result;
   }
}