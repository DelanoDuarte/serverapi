/**
 * 
 */
package br.simpleapp.jobs;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

/**
 * @author Delano Jr
 *
 */

@Stateless
public class JobTask implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private TimerService timerService;

	public void setFutureTimer(Date date) throws ParseException {

		Calendar dateParsed = Calendar.getInstance();
		dateParsed.setTime(date);
		dateParsed.add(Calendar.DATE, 1);

		timerService.createSingleActionTimer(dateParsed.getTime(), new TimerConfig());

	}

	@Timeout
	public void timeout(Timer timer) {
		System.out.println("TimerBean: timeout occurred");
	}
}