
package app.services;

import app.models.Officer;
import app.repositories.ApplicationUserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class OfficerService implements UserDetailsService {

    private final ApplicationUserRepo applicationUserRepo;

    public OfficerService(ApplicationUserRepo applicationUserRepo) {
        this.applicationUserRepo = applicationUserRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Officer officer = applicationUserRepo.findAllByUsername(username);
        if (officer == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return officer;
    }

}