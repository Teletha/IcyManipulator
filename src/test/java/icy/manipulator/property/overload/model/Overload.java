package icy.manipulator.property.overload.model;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link OverloadModel}.
 */
@Generated("Icy Manipulator")
public abstract class Overload extends OverloadModel {

    /**
     * Create special method invoker.
     *
     * @param name A target method name.
     * @param parameterTypes A list of method parameter types.
     * @return A special method invoker.
     */
    private static final MethodHandle invoker(String name, Class... parameterTypes)  {
        try {
            Method method = OverloadModel.class.getDeclaredMethod(name, parameterTypes);
            method.setAccessible(true);
            return MethodHandles.lookup().unreflect(method);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The overload method invoker. */
    private static final MethodHandle sizeint= invoker("size", int.class);

    /** The overload method invoker. */
    private static final MethodHandle sizeByTextjavalangString= invoker("sizeByText", String.class);

    /** The overload method invoker. */
    private static final MethodHandle dateintintint= invoker("date", int.class, int.class, int.class);

    /** The overload method invoker. */
    private static final MethodHandle today= invoker("today");

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = Overload.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle sizeUpdater = updater("size");

    /** The final property updater. */
    private static final MethodHandle dateUpdater = updater("date");

    /** The exposed property. */
    public final BigDecimal size;

    /** The exposed property. */
    public final LocalDate date;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Overload() {
        this.size = null;
        this.date = null;
    }

    /**
     * Retrieve size property.
     */
    @Override
    public final BigDecimal size() {
        return this.size;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final BigDecimal getSize() {
        return this.size;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private void setSize(BigDecimal value) {
        ((ÅssignableSize) this).size(value);
    }

    /**
     * Retrieve date property.
     */
    @Override
    public final LocalDate date() {
        return this.date;
    }

    /**
     * Provide classic getter API.
     */
    @SuppressWarnings("unused")
    private final LocalDate getDate() {
        return this.date;
    }

    /**
     * Provide classic setter API.
     */
    @SuppressWarnings("unused")
    private void setDate(LocalDate value) {
        ((ÅssignableDate) this).date(value);
    }

    /** The singleton builder. */
    public static final  Ìnstantiator<?> with = new Ìnstantiator();

    /**
     * Builder namespace for {@link Overload}.
     */
    public static final class Ìnstantiator<Self extends Overload & ÅssignableÅrbitrary<Self>> {

        /**
         * Create uninitialized {@link Overload}.
         */
        public final <T extends ÅssignableDate<Self>> T size(BigDecimal value) {
            return (T) new Åssignable().size(value);
        }

        /**
         * Create uninitialized {@link Overload}.
         */
        public final <T extends ÅssignableDate<Self>> T size(int number) {
            return (T) new Åssignable().size(number);
        }

        /**
         * Create uninitialized {@link Overload}.
         */
        public final <T extends ÅssignableDate<Self>> T sizeByText(String number) {
            return (T) new Åssignable().sizeByText(number);
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableSize<Next> {
        /**
         * The base setter.
         */
        default Next size(BigDecimal value) {
            try {
                sizeUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }

        /**
         * The overload setter.
         */
        default Next size(int number) {
            try {
                return size((BigDecimal) sizeint.invoke(this, number));
            } catch (Throwable e) {
                throw new Error(e);
            }
        }

        /**
         * The overload setter.
         */
        default Next sizeByText(String number) {
            try {
                return size((BigDecimal) sizeByTextjavalangString.invoke(this, number));
            } catch (Throwable e) {
                throw new Error(e);
            }
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableDate<Next> {
        /**
         * The base setter.
         */
        default Next date(LocalDate value) {
            try {
                dateUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (Next) this;
        }

        /**
         * The overload setter.
         */
        default Next date(int year, int month, int day) {
            try {
                return date((LocalDate) dateintintint.invoke(this, year, month, day));
            } catch (Throwable e) {
                throw new Error(e);
            }
        }

        /**
         * The overload setter.
         */
        default Next today() {
            try {
                return date((LocalDate) today.invoke(this));
            } catch (Throwable e) {
                throw new Error(e);
            }
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary<Next extends Overload> {
    }

    /**
     * Internal aggregated API.
     */
    protected static interface ÅssignableAll extends ÅssignableSize, ÅssignableDate {
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Overload implements ÅssignableAll, ÅssignableÅrbitrary {
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Size = "size";
        static final String Date = "date";
    }
}
