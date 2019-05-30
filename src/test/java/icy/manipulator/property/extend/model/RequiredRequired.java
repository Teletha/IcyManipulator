package icy.manipulator.property.extend.model;

import icy.manipulator.property.extend.model.RequiredRequired;
import icy.manipulator.property.extend.model.RequiredRequiredModel;
import icy.manipulator.property.model.Multiple;
import java.lang.Override;
import java.lang.String;
import java.lang.Throwable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.StringJoiner;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link RequiredRequiredModel}.
 */
@Generated("Icy Manipulator")
public abstract class RequiredRequired extends RequiredRequiredModel {

    /**
     * Deceive complier that the specified checked exception is unchecked exception.
     *
     * @param <T> A dummy type for {@link RuntimeException}.
     * @param throwable Any error.
     * @return A runtime error.
     * @throws T Dummy error to deceive compiler.
     */
    private static final <T extends Throwable> T quiet(Throwable throwable) throws T {
        throw (T) throwable;
    }

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = RequiredRequired.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle nicknameUpdater = updater("nickname");

    /** The exposed property. */
    public final String nickname;

    /**
     * HIDE CONSTRUCTOR
     */
    protected RequiredRequired() {
        this.nickname = null;
    }

    /**
     * Return the nickname property.
     *
     * @return A value of nickname property.
     */
    @Override
    public final String nickname() {
        return this.nickname;
    }

    /**
     * Provide classic getter API.
     *
     * @return A value of nickname property.
     */
    @SuppressWarnings("unused")
    private final String getNickname() {
        return this.nickname;
    }

    /**
     * Provide classic setter API.
     *
     * @paran value A new value of nickname property to assign.
     */
    private final void setNickname(String value) {
        if (value == null) {
            throw new IllegalArgumentException("The nickname property requires non-null value.");
        }
        try {
            nicknameUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw quiet(e);
        }
    }

    /**
     * Show all property values.
     *
     * @return All property values.
     */
    @Override
    public String toString() {
        StringJoiner builder = new StringJoiner(", ", "RequiredRequired [", "]");
        builder.add("name=" + name);
        builder.add("stand=" + stand);
        builder.add("age=" + age);
        builder.add("nickname=" + nickname);
        return builder.toString();
    }

    /**
     * Generates a hash code for a sequence of property values. The hash code is generated as if all the property values were placed into an array, and that array were hashed by calling Arrays.hashCode(Object[]). 
     *
     * @return A hash value of the sequence of property values.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, stand, age, nickname);
    }

    /**
     * Returns true if the all properties are equal to each other and false otherwise. Consequently, if both properties are null, true is returned and if exactly one property is null, false is returned. Otherwise, equality is determined by using the equals method of the base model. 
     *
     * @return true if the all properties are equal to each other and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof RequiredRequired == false) {
            return false;
        }

        RequiredRequired other = (RequiredRequired) o;
        if (!Objects.equals(name, other.name)) {
            return false;
        }
        if (!Objects.equals(stand, other.stand)) {
            return false;
        }
        if (age != other.age) {
            return false;
        }
        if (!Objects.equals(nickname, other.nickname)) {
            return false;
        }
        return true;
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Namespace for {@link RequiredRequired}  builder methods.
     */
    public static final class Ìnstantiator<Self extends RequiredRequired & ÅssignableÅrbitrary<Self>> {

        /**
         * Create new {@link RequiredRequired} with the specified name property.
         * 
         * @return The next assignable model.
         */
        public final ÅssignableStand<ÅssignableAge<ÅssignableNickname<Self>>> name(String name) {
            Åssignable o = new Åssignable();
            o.name(name);
            return o;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableNickname<Next> {

        /**
         * Assign nickname property.
         * 
         * @param value A new value to assign.
         * @return The next assignable model.
         */
        default Next nickname(String value) {
            ((RequiredRequired) this).setNickname(value);
            return (Next) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends RequiredRequired> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableNickname, Multiple.ÅssignableAll {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends RequiredRequired implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Nickname = "nickname";
    }
}
