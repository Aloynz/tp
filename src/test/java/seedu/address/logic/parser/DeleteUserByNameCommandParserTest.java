package seedu.address.logic.parser;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.DeleteUserByNameCommand;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.FullNamePredicate;
import seedu.address.model.person.Person;

public class DeleteUserByNameCommandParserTest {
    private DeleteUserByNameCommandParser parser = new DeleteUserByNameCommandParser();
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void parse_validArgs_returnsDeleteUserByNameCommand() {
        Person personToDelete = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        FullNamePredicate predicate = new FullNamePredicate(personToDelete.getName().toString());
        assertParseSuccess(parser, personToDelete.getName().toString(), new DeleteUserByNameCommand(predicate));
    }

}
