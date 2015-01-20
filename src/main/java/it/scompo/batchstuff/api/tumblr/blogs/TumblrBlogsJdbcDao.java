package it.scompo.batchstuff.api.tumblr.blogs;

import it.scompo.batchstuff.api.tumblr.beans.PersistableBlog;
import it.scompo.batchstuff.utils.ObjectSerializationUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TumblrBlogsJdbcDao implements TumblrBlogDao {

	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void init() {

		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<PersistableBlog> getAllBlogs() {

		return jdbcTemplate.query("select * from persistable_blog",
				new RowMapper<PersistableBlog>() {

					@Override
					public PersistableBlog mapRow(ResultSet rs, int rowNum)
							throws SQLException {

						PersistableBlog res;

						res = ObjectSerializationUtils.deserialize(
								rs.getString(2), PersistableBlog.class);

						return res;
					}

				});
	}
}
