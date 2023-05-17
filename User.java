/*
 * Licensed to The Apereo Foundation under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.
 *
 * The Apereo Foundation licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
*/
package org.unitime.timetable.model;

import org.unitime.timetable.model.base.BaseUser;
import org.unitime.timetable.model.dao.UserDAO;

/**
 * @author Tomas Muller
 */
public class User extends BaseUser {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public User () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public User (java.lang.String username) {
		super(username);
	}

/*[CONSTRUCTOR MARKER END]*/
    
    public static User findByExternalId(String externalId) {
        return (User)
            new UserDAO().
            getSession().
            createQuery("select u from User u where u.externalUniqueId=:externalId").
            setString("externalId", externalId).
            setCacheable(true).
            setMaxResults(1).
            uniqueResult();
    }

    public static User findByUserName(String userName) {
        return (User)
            new UserDAO().
            getSession().
            createQuery("select u from User u where u.username=:userName").
            setString("userName", userName).
            setCacheable(true).
            setMaxResults(1).
            uniqueResult();
    }
	public static User findByPhoneNumber(String phoneNumber) {
		return (User)
				new UserDAO()
						.getSession()
						.createQuery("select u from User u where u.phoneNumber=:phoneNumber")
						.setString("phoneNumber", phoneNumber)
						.setCacheable(true)
						.setMaxResults(1)
						.uniqueResult();
	}
    
}
