package icy.manipulator.property.extend;

import icy.manipulator.property.object.Multiple;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link SubclassModel}.
 */
@Generated("Icy Manipulator")
public abstract class Subclass extends SubclassModel {

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = Subclass.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle nicknameUpdater = updater("nickname");

    /** The exposed property. */
    public final String nickname;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Subclass() {
        this.nickname = null;
    }

    /**
     * Retrieve nickname property.
     */
    @Override
    public final String nickname() {
        return this.nickname;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final String getNickname() {
        return this.nickname;
    }

    /**
     * Provide classic setter API.
     */
    private final void setNickname(String value) {
        try {
            nicknameUpdater.invoke(this, value);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<Subclass> with = new Ìnstantiator();

    /**
     * Builder namespace for {@link Subclass}.
     */
    public static class Ìnstantiator<Self> extends Multiple.Ìnstantiator<ÅssignableNickname<Self>> {

        protected ÅssignableAll base() {
            return new Åssignable();
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableNickname<Next> {

        /**
         * The setter.
         */
        default Next nickname(String value) {
            ((Subclass) this).setNickname(value);
            return (Next) this;
        }
    }

    /**
     * Internal assignment API.
     */
    protected static interface ÅssignableAll extends ÅssignableNickname, Multiple.ÅssignableAll {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Subclass implements ÅssignableAll {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Nickname = "nickname";
    }
}