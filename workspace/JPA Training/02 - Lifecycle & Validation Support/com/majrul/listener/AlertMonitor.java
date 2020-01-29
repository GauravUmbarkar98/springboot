package com.majrul.listener;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

public class AlertMonitor {

	@PrePersist
	protected void validateCreate(Account acct) {
		if (acct.getBalance() < 10000)
			throw new AccountException(
					"Insufficient balance to open an account");
	}

	@PostPersist
	public void newAccountAlert(Account acct) {
		//some logic to send new account details to the marketing dept
		//Alerts.sendMarketingInfo(acct.getAccountId());
	}
}
