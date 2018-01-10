package com.hj.pers.entites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import com.hj.pers.entites.impl.User;
import com.hj.pers.service.UserService;

/**基础实体
 * 
 * @author hujian
 *
 */
@MappedSuperclass
public class Base {
	
		//创建人id
		@Column(name="create_by")
		private Long createBy;
		
		//创建日期
		@Column(name="create_date")
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date createDate;
		
		//更新日期
		@Column(name="update_date")
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date updateDate;
		
		@Column(name="author")
		private String author;
		
		public Long getCreateBy() {
			return createBy;
		}
		public void setCreateBy(Long createBy) {
			this.createBy = createBy;
		}
		public Date getCreateDate() {
			return createDate;
		}
		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}
		public Date getUpdateDate() {
			return updateDate;
		}
		public void setUpdateDate(Date updateDate) {
			this.updateDate = updateDate;
		}
		public String getAuthor() {
				return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		
}
