package asylum.nursebot.persistence.modules;

import asylum.nursebot.modules.birthdays.Privacy;
import asylum.nursebot.persistence.selfbuilding.*;
import org.javalite.activejdbc.Model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class BirthdaysGratulation extends Model implements Selfbuilding {

	@Override
	public String getSelfbuildingName() {
		return getTableName();
	}

	@Override
	public List<Column> getSelfbuildingColumns() {
		return Arrays.asList(new Column[]{
				new Column("id", new Type(DataType.BIGINT))
						.setKey(Key.PRIMARY_KEY)
						.setAutoincrement(true),
				new Column("userid", new Type(DataType.INT))
						.setNotNullFlag(true),
				new Column("chatid", new Type(DataType.BIGINT))
						.setNotNullFlag(true)
		});
	}

	public BirthdaysGratulation() {
	}

	public BirthdaysGratulation(int userid, long chatid) {
		set("userid", userid);
		set("chatid", chatid);
	}

	public static BirthdaysGratulation find(int userid, long chatid) {
		List<BirthdaysGratulation> tmp = find("userid = ? AND chatid = ?", userid, chatid);
		if (tmp.size() != 1)
			return null;
		return tmp.get(0);
	}
}
