package org.lzj.poa.entity;

import java.io.Serializable;

/**回复
 * @author lzj
 *
 */
public class Reply extends Article implements Serializable{
	
	private static final long serialVersionUID = -1442821170338769758L;
	
	private Topic topic;

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	

}
