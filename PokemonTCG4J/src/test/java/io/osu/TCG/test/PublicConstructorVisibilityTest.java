package io.osu.TCG.test;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Test;

import io.osu.TCG.CardArray;
import io.osu.TCG.SetArray;

public class PublicConstructorVisibilityTest {

	@Test
	public void cardArrayConstructorsArePublic() throws NoSuchMethodException {
		Constructor<CardArray> noArg = CardArray.class.getConstructor();
		Constructor<CardArray> query = CardArray.class.getConstructor(String.class, String.class);

		assertTrue(Modifier.isPublic(noArg.getModifiers()));
		assertTrue(Modifier.isPublic(query.getModifiers()));
	}

	@Test
	public void setArrayConstructorsArePublic() throws NoSuchMethodException {
		Constructor<SetArray> noArg = SetArray.class.getConstructor();
		Constructor<SetArray> query = SetArray.class.getConstructor(String.class, String.class);

		assertTrue(Modifier.isPublic(noArg.getModifiers()));
		assertTrue(Modifier.isPublic(query.getModifiers()));
	}
}
