package com.example.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

import com.example.demo.user.QBlogPost;
import com.example.demo.user.QUsuario2;
import com.example.demo.user.Usuario2;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.jpa.impl.JPAInsertClause;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;



@SpringBootApplication
public class TeoriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeoriaApplication.class, args);
		
		
		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("PU");
		EntityManager em1 = emf1.createEntityManager();
		JPAQueryFactory query = new JPAQueryFactory(em1);
		
		QUsuario2 usuario2 = QUsuario2.usuario2;
		Usuario2 found = query.selectFrom(usuario2)
		      .where(usuario2.id.eq(1L))
		      .fetchOne();
		
		System.out.println("\nFound user: " + found.getLogin());
		
		Usuario2 newUser = new Usuario2();
		newUser.setDesabilitado(true);
		newUser.setLogin("Alek");
		
		JPAQueryFactory test = new JPAQueryFactory(em1);
		
		QUsuario2 insert1 = QUsuario2.usuario2;

		JPAInsertClause update = test.insert(usuario2)
				.columns(usuario2.desabilitado,usuario2.login);
				
		update.values(newUser.getDesabilitado(), newUser.getLogin())
		.set(newUser.getDesabilitado(), newUser.getLogin())
		;
		update.execute();
				
		
	

		
	}

		
			
		

			
//			Usuario2 usuario2 = new Usuario2();
//			QUsuario2 usuario = QUsuario2.usuario2;
//			QBlogPost blogPost = QBlogPost.blogPost;
//			
//			Usuario2 c = queryFactory.selectFrom(usuario)
//			  .where(usuario.login.eq("David"))
//			  .fetchOne();
//
//			List<Usuario2> lista = queryFactory.selectFrom(usuario)
//					  .orderBy(usuario.login.asc())
//					  .fetch();
//
//
//			NumberPath<Long> count = Expressions.numberPath(Long.class, "c");
//
//			List<Tuple> userTitleCounts = queryFactory.select(
//			  blogPost.titulo, blogPost.id.count().as(count))
//			  .from(blogPost)
//			  .groupBy(blogPost.titulo)
//			  .orderBy(count.desc())
//			  .fetch();

//
//			List<Usuario2> usuarioss = queryFactory.selectFrom(usuario2)
//			  .innerJoin(usuario2.blogPosts, blogPost)
//			  .on(blogPost.titulo.eq("Hola Mundo!"))
//			  .fetch();
//
//			
//			List<Uuario2r> users = queryFactory.selectFrom(usuario2)
//					  .where(usuario2.id.in(
//					    JPAExpressions.select(blogPost.usuario2.id)
//					      .from(blogPost)
//					      .where(blogPost.titulo.eq("Hola mundo!"))))
//					  .fetch();
//
//			
//			queryFactory.update(usuario2)
//			  .where(usuario2.login.eq("Ash"))
//			  .set(usuario2.login, "Ash2")
//			  .set(usuario2.desabilitado, true)
//			  .execute();
//
//			
//			queryFactory.delete(usuario2)
//			  .where(usuario2.login.eq("David"))
//			  .execute();
//

	

}
