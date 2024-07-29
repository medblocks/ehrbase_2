package org.ehrbase.plugin.dto;

import java.util.Objects;

/*
 * Copyright (c) 2024 vitasystems GmbH.
 *
 * This file is part of project EHRbase
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import org.openehr.schemas.v1.OPERATIONALTEMPLATE;
public class TemplateWithXUser {
   /**
    * Wrapper for an Template with <code>Template</code> {@link template_id} 
    */
    private final OPERATIONALTEMPLATE OPERATIONALTEMPLATE;
    private String x_user;

    public TemplateWithXUser(OPERATIONALTEMPLATE OPERATIONALTEMPLATE){
      this.OPERATIONALTEMPLATE = OPERATIONALTEMPLATE;
    }
    public TemplateWithXUser(OPERATIONALTEMPLATE OPERATIONALTEMPLATE, String x_user){
      this.OPERATIONALTEMPLATE = OPERATIONALTEMPLATE;
      this.x_user = x_user;
    }
    public OPERATIONALTEMPLATE getOperationalTemplate() {
        return OPERATIONALTEMPLATE;
    }

    @Override
    public String toString() {
        return "TemplateWithXUser{" + "OPERATIONALTEMPLATE=" + OPERATIONALTEMPLATE + ", x_user=\'" + x_user + '\''+'}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TemplateWithXUser that = (TemplateWithXUser) o;
        return Objects.equals(OPERATIONALTEMPLATE, that.OPERATIONALTEMPLATE) && Objects.equals(x_user, that.x_user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(OPERATIONALTEMPLATE, x_user);
    }
    public String getX_User(){
        return x_user;
    }
}
