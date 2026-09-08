package com.bistroops.employee.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bistroops.util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import static com.bistroops.employee.model.Constants.PAGE_MAX_RESULT;

public class EmployeeDAOImpl implements EmployeeDAO {

	// SessionFactory 為 thread-safe，可宣告為屬性讓請求執行緒們共用
	private SessionFactory factory;

	public EmployeeDAOImpl() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	// Session 為 not thread-safe，所以此方法在各個增刪改查方法裡呼叫
	// 以避免請求執行緒共用了同個 Session
	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	
	@Override
	public void insert(EmployeeVO entity) {
		// TODO Auto-generated method stub
		getSession().persist(entity);
	}

	@Override
	public void update(EmployeeVO entity) {
		// TODO Auto-generated method stub
		getSession().merge(entity);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		 EmployeeVO employee = getSession().find(EmployeeVO.class, id);

		    if (employee != null) {
		        getSession().remove(employee);
		    }
	}

	@Override
	public EmployeeVO getById(Integer id) {
		// TODO Auto-generated method stub
		return getSession().find(EmployeeVO.class, id);
	}

	@Override
	public List<EmployeeVO> getAll() {
		// TODO Auto-generated method stub
		  return getSession().createQuery("FROM EmployeeVO", EmployeeVO.class).getResultList();
	}

	@Override
	public List<EmployeeVO> getByCompositeQuery(Map<String, String> map) {
		// TODO Auto-generated method stub
		  if (map.size() == 0) {
		        return getAll();
		    }

		    CriteriaBuilder builder = getSession().getCriteriaBuilder();
		    CriteriaQuery<EmployeeVO> criteria = builder.createQuery(EmployeeVO.class);
		    Root<EmployeeVO> root = criteria.from(EmployeeVO.class);

		    List<Predicate> predicates = new ArrayList<>();

		    for (Map.Entry<String, String> row : map.entrySet()) {

		        if ("empName".equals(row.getKey())) {
		            predicates.add(
		                builder.like(root.get("empName"), "%" + row.getValue() + "%")
		            );
		        }

		        if ("empTel".equals(row.getKey())) {
		            predicates.add(
		                builder.like(root.get("empTel"), "%" + row.getValue() + "%")
		            );
		        }

		        if ("empAdd".equals(row.getKey())) {
		            predicates.add(
		                builder.like(root.get("empAdd"), "%" + row.getValue() + "%")
		            );
		        }

		        if ("empStatus".equals(row.getKey())) {
		            predicates.add(
		                builder.equal(root.get("empStatus"), row.getValue())
		            );
		        }

		        if (map.containsKey("startsal") && map.containsKey("endsal")) {
		            predicates.add(
		                builder.between(
		                    root.get("empSal"),
		                    Integer.valueOf(map.get("startsal")),
		                    Integer.valueOf(map.get("endsal"))
		                )
		            );
		        }
		        if ("startsal".equals(row.getKey())) {
		            if (!map.containsKey("endsal")) {
		                predicates.add(
		                    builder.greaterThanOrEqualTo(
		                        root.get("empSal"),
		                        Integer.valueOf(row.getValue())
		                    )
		                );
		            }
		        }

		        if ("endsal".equals(row.getKey())) {
		            if (!map.containsKey("startsal")) {
		                predicates.add(
		                    builder.lessThanOrEqualTo(
		                        root.get("empSal"),
		                        Integer.valueOf(row.getValue())
		                    )
		                );
		            }
		        }
		    }

		    criteria.where(
		        builder.and(
		            predicates.toArray(new Predicate[predicates.size()])
		        )
		    );

		    criteria.orderBy(builder.asc(root.get("empNo")));

		    TypedQuery<EmployeeVO> query = getSession().createQuery(criteria);

		    return query.getResultList();
		
	}

	@Override
	public List<EmployeeVO> getAll(int currentPage) {
		// TODO Auto-generated method stub
		 int first = (currentPage - 1) * PAGE_MAX_RESULT;

		    return getSession().createQuery("from EmployeeVO", EmployeeVO.class)
		            .setFirstResult(first)
		            .setMaxResults(PAGE_MAX_RESULT)
		            .getResultList();
	}

	@Override
	public long getTotal() {
		// TODO Auto-generated method stub
		return getSession().createQuery("select count(*) from EmployeeVO", Long.class).getSingleResult();
	}

}
