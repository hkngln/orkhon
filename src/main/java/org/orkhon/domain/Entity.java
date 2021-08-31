package org.orkhon.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Tüm domain bunu implemente edecek
 * @param <T>
 */
public abstract class Entity<T> implements Serializable {
        protected T id;

        protected Entity() {
        }

        protected Entity(T id) {
            this.id = id;
        }

        public T getId() {
            return id;
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Entity)) return false;

            Entity<T> entity = (Entity<T>) o;
            return Objects.equals(id, entity.id);
        }

        @Override
        public int hashCode() {
            return id != null ? id.hashCode() : 0;
        }

}
