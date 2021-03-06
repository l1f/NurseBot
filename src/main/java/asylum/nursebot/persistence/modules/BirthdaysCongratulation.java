package asylum.nursebot.persistence.modules;

import java.util.Arrays;
import java.util.List;

import asylum.nursebot.persistence.selfbuilding.Column;
import asylum.nursebot.persistence.selfbuilding.DataType;
import asylum.nursebot.persistence.selfbuilding.Key;
import asylum.nursebot.persistence.selfbuilding.Selfbuilding;
import asylum.nursebot.persistence.selfbuilding.Type;
import org.javalite.activejdbc.Model;

public class BirthdaysCongratulation extends Model implements Selfbuilding {

	@Override
	public String getSelfbuildingName() {
		return getTableName();
	}

	@Override
	public List<Column> getSelfbuildingColumns() {
		return Arrays.asList(
				new Column("id", new Type(DataType.BIGINT))
				.setKey(Key.PRIMARY_KEY)
				.setAutoincrement(true),
				new Column("userid", new Type(DataType.INT))
						.setNotNullFlag(true),
				new Column("chatid", new Type(DataType.BIGINT))
						.setNotNullFlag(true));
	}

	public BirthdaysCongratulation() {
	}

	public BirthdaysCongratulation(int userid, long chatid) {
		set("userid", userid);
		set("chatid", chatid);
	}

	public static BirthdaysCongratulation find(int userid, long chatid) {
		List<BirthdaysCongratulation> tmp = find("userid = ? AND chatid = ?", userid, chatid);
		if (tmp.size() != 1)
			return null;
		return tmp.get(0);
	}

	public static List<BirthdaysCongratulation> findByChatId(long chatid) {
		return find("chatid = ?", chatid);
	}

	public static List<BirthdaysCongratulation> findByUserId(int userid) {
		return find("userid = ?", userid);
	}

	public int getUserId() {
		return getInteger("userid");
	}

	public long getChatId() {
		return getLong("chatid");
	}
}
