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

public class DataException extends RuntimeException {

	public DataException() {
	}

	public DataException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataException(String message) {
		super(message);
	}

	public DataException(Throwable cause) {
		super(cause);
	}
}
