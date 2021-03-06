/*******************************************************************************
 * Copyright 2015-2018 Capgemini SE.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 ******************************************************************************/
package com.capgemini.devonfw.module.winauthad.base;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.devonfw.module.winauthad.common.impl.security.UserDetailsContextMapperAD;

import io.oasp.module.test.common.base.ComponentTest;

/**
 * This is the test-case for {@link UserDetailsContextMapperAD}
 *
 * @author jhcore
 * @since 1.1
 */
@SpringBootTest(classes = SpringBootApp.class)
public class UserDetailsContextMapperADTest extends ComponentTest {
  @Inject
  private UserDetailsContextMapperAD userDetailsContextMapperAD;

  /**
   * Test method for
   * {@link com.capgemini.devonfw.module.winauth.common.impl.security.UserDetailsContextMapperAD#getAuthenticationSource()}
   * .
   */
  @Test
  public void testGetAuthenticationSource() {

    // given
    assertThat(this.userDetailsContextMapperAD).isNotNull();

    // then
    assertThat(this.userDetailsContextMapperAD.getAuthenticationSource()).isNotNull();
  }

  /**
   * Test method for
   * {@link com.capgemini.devonfw.module.winauth.common.impl.security.UserDetailsContextMapperAD#getGroupMapperAD()}.
   */
  @Test
  public void testGetGroupMapperAD() {

    // given
    assertThat(this.userDetailsContextMapperAD).isNotNull();

    // then
    assertThat(this.userDetailsContextMapperAD.getGroupMapperAD()).isNotNull();
  }

}
