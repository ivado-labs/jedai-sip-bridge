/*
 * ____________________________________________________________________________
 *
 * (c) 2019, CHUSJ Org. All Rights Reserved
 *
 * The contents of this file may not be disclosed, copied or duplicated in
 * any form, in whole or part, without the prior written permission of
 * CHUSJ Org.
 * ____________________________________________________________________________
 */

package org.chusj.crhsj.sip_bridge.entities;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Gender {
	MALE,
	FEMALE,
	OTHER,
	UNKNOWN,
	NULL;

	@JsonCreator
	public static Gender fromCode(String codeString) throws DataException {
		if (!"".equals(codeString)) {
			if ("male".equalsIgnoreCase(codeString) || "m".equalsIgnoreCase(codeString)) {
				return MALE;
			} else if ("female".equalsIgnoreCase(codeString) || "f".equalsIgnoreCase(codeString)) {
				return FEMALE;
			} else if ("other".equalsIgnoreCase(codeString)) {
				return OTHER;
			} else if ("unknown".equalsIgnoreCase(codeString)) {
				return UNKNOWN;
			} else {
				throw new DataException("Unknown AdministrativeGender code '" + codeString + "'");
			}
		} else {
			// Todo: come back to this. see if you want to use Gender.Null or not
			return null;
		}
	}
}
