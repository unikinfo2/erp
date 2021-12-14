package net.unikinfo.neoserp.aplicacao;

import com.google.common.collect.ImmutableMap;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.*;

public class AbstractFacade {

    protected String getCurrentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return currentUserName;
        }
        return "anonymous";
    }

    public static class BusinessOperationResponse {

        private final Map<String,Object> payload = new LinkedHashMap<>();
        private final List<Map<String,Object>> errors = new ArrayList<>();

        public BusinessOperationResponse(String message) {
            this.addGlobalErrorMessage(message);
        }

        public BusinessOperationResponse() {
        }

        public static BusinessOperationResponse empty() {
            return new BusinessOperationResponse();
        }

        public void addGlobalErrorMessage(String message) {
            errors.add(ImmutableMap.of("type", "global", "message", message));
        }

       public void addFieldScopedErrorMessage(String field, String message) {
            errors.add(ImmutableMap.of("type", "field", "field", field, "message", message));
       }

        public List<Map<String,Object>> getErrors() {
            return Collections.unmodifiableList(errors);
        }

        public boolean hasErrors() {
            return errors.size() > 0;
        }

        public Map<String,Object> getPayload() {
            return payload;
        }

        public void addToPayload(String name, Object value) {
            this.payload.put(name, value);
        }

        public BusinessOperationResponse data(String name, Object value) {
            this.payload.put(name, value);
            return this;
        }

        public boolean isSuccess() {
            return !hasErrors();
        }
    }
}
