package com.bistroops.mealtype.model;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bistroops.meal.model.MealVO;
import com.bistroops.util.HibernateUtil;

public class MealtypeDAOhibernate implements MealtypeDAO {
	
	//SessionFactory 為 thread-safe，宣告為大家共用。
	private SessionFactory factory;

	public MealtypeDAOhibernate() {
			factory = HibernateUtil.getSessionFactory();
		}
	
	//避免執行緒用同一個Session放置方法內
	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public void insert(MealtypeVO MealtypeVO) {
		getSession().persist(MealtypeVO);
	}

	@Override
	public void update(MealtypeVO MealtypeVO) {
		getSession().merge(MealtypeVO);
		
	}

	@Override
	public void delete(Integer mealTypeNo) {
		MealtypeVO mealtype = getSession().find(MealtypeVO.class,mealTypeNo);
		if(mealtype != null) {
			getSession().remove(mealtype);
		}
	}

	@Override
	public MealtypeVO findByNo(Integer mealTypeNo) {
		return getSession().find(MealtypeVO.class,mealTypeNo);
	}

	@Override
	public List<MealtypeVO> getByNameQuery(String name){
		
		return getSession().createQuery("from MealtypeVO where mealtypeName like :typeName order by mealtypeNo",MealtypeVO.class)
				.setParameter( ":typeName" , "%" + name + "%")
				.getResultList();

	}
	
	
	@Override
	public List<MealtypeVO> getAll() {
		return getSession().createQuery("from MealtypeVO",MealtypeVO.class).getResultList();
	}

	@Override
	public Set<MealVO> getMealByTpye(Integer mealtypeNo) {
		MealtypeVO mealtypes = getSession().find(MealtypeVO.class, mealtypeNo);
			
		return mealtypes.getMeals();
//		return getSession().createQuery("from MealVO Where mealtpyeNo = :typeNo order by mealNo",MealVO.class)
//				.setParameter("typeNo", mealtypeNo).getResultList(); 
	}




	
}
