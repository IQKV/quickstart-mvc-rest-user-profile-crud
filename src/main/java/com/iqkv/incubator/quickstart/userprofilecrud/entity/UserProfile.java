/*
 * Copyright 2024 IQKV Team.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.iqkv.incubator.quickstart.userprofilecrud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = UserProfile.TABLE_NAME)
public class UserProfile {

  protected static final String TABLE_NAME = "quickstart_restful_user_profiles";

  @Id
  @SequenceGenerator(
      name = "user_profile_id_seq",
      sequenceName = "user_profile_id_seq",
      initialValue = 1,
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "user_profile_id_seq"
  )
  private Long id;

  @Email
  @Size(min = 5, max = 120)
  @Column(length = 120, unique = true)
  private String email;

  private boolean active;

  public UserProfile(String email, boolean active) {
    this.email = email;
    this.active = active;
  }

  @Override
  public String toString() {
    return "UserProfile{" +
           "id=" + id +
           ", email='" + email + '\'' +
           ", active=" + active +
           '}';
  }
}
