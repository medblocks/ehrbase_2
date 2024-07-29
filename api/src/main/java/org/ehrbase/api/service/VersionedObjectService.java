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
package org.ehrbase.api.service;

import com.nedap.archie.rm.archetyped.Locatable;
import com.nedap.archie.rm.support.identification.ObjectVersionId;
import java.util.Optional;
import java.util.UUID;
import org.ehrbase.openehr.sdk.response.dto.ehrscape.FolderDto;

/**
 * Service layer interface for versioned openEHR objects.<br>
 * Helps to always handle the necessary metadata and streamlines C(R)UD
 * operations.<br>
 * Retrieval is
 * 
 * @param <T> Class of target versioned object, e.g.
 *            {@link com.nedap.archie.rm.directory.Folder}.
 * @param <U> Class of return value of create and update methods. For instance,
 *            {@link FolderDto}. Will be wrapped in an {@link Optional}.
 */
public interface VersionedObjectService<T extends Locatable, U> {

    /**
     * Creation with given audit meta-data. Will create a new ad-hoc contribution.
     * 
     * @param ehrId       EHR ID of context
     * @param objData     Payload object data
     * @param systemId    Audit system ID
     * @param committerId Audit committer ID
     * @param description Optional audit description text
     * @return {@link T} typed response wrapped in {@link Optional}
     */
    @Deprecated(forRemoval = true)
    default Optional<U> create(UUID ehrId, T objData, UUID systemId, UUID committerId, String description) {
        throw new UnsupportedOperationException();
    }

    /**
     * Creation with a given contribution, and its audit meta-data.
     *
     * @param ehrId        EHR ID of context
     * @param objData      Payload object data
     * @param contribution Contribution for operation
     * @param audit
     * @return {@link T} typed response wrapped in {@link Optional}
     */
    Optional<U> create(UUID ehrId, T objData, String x_user, UUID contribution, UUID audit);

    /**
     * Creation with default audit meta-data. Will create a new ad-hoc contribution.
     * 
     * @param ehrId   EHR ID of context
     * @param objData Payload object data
     * @return {@link T} typed response wrapped in {@link Optional}
     */
    Optional<U> create(UUID ehrId, T objData, String x_user);

    /**
     * Update with given audit meta-data. Will create a new ad-hoc contribution.
     * 
     * @param ehrId       EHR ID of context
     * @param targetObjId ID of target object
     * @param objData     Payload object data
     * @param systemId    Audit system ID
     * @param committerId Audit committer ID
     * @param description Optional audit description text
     * @return {@link T} typed response wrapped in {@link Optional}
     */
    @Deprecated(forRemoval = true)
    default Optional<U> update(
            UUID ehrId, ObjectVersionId targetObjId, T objData, UUID systemId, UUID committerId, String description) {
        throw new UnsupportedOperationException();
    }

    /**
     * Update with a given contribution, and its audit meta-data.
     *
     * @param ehrId        EHR ID of context
     * @param targetObjId  ID of target object
     * @param objData      Payload object data
     * @param contribution Contribution for operation
     * @param audit
     * @return {@link T} typed response wrapped in {@link Optional}
     */
    Optional<U> update(UUID ehrId, ObjectVersionId targetObjId, T objData, String x_user, UUID contribution,
            UUID audit);

    /**
     * Update with default audit meta-data. Will create a new ad-hoc contribution.
     * 
     * @param ehrId       EHR ID of context
     * @param targetObjId ID of target object
     * @param objData     Payload object data
     * @return {@link T} typed response wrapped in {@link Optional}
     */
    Optional<U> update(UUID ehrId, ObjectVersionId targetObjId, T objData, String x_user);

    /**
     * Deletion with given audit meta-data. Will create a new ad-hoc contribution.
     *
     * @param ehrId       EHR ID of context
     * @param targetObjId ID of target object
     * @param systemId    Audit system ID
     * @param committerId Audit committer ID
     * @param description Optional audit description text
     */
    @Deprecated(forRemoval = true)
    default void delete(UUID ehrId, ObjectVersionId targetObjId, UUID systemId, UUID committerId, String description) {
        throw new UnsupportedOperationException();
    }

    /**
     * Deletion with a given contribution, and its audit meta-data.
     *
     * @param ehrId        EHR ID of context
     * @param targetObjId  ID of target object
     * @param contribution Contribution for operation
     * @param audit
     */
    void delete(UUID ehrId, ObjectVersionId targetObjId, String x_user, UUID contribution, UUID audit);

    /**
     * Deletion with default audit meta-data. Will create a new ad-hoc contribution.
     *
     * @param ehrId       EHR ID of context
     * @param targetObjId ID of target object
     */
    void delete(UUID ehrId, ObjectVersionId targetObjId, String x_user);
}
