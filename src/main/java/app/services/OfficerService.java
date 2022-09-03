package app.services;

import app.models.Crew;
import app.models.Officer;
import app.repositories.ApplicationUserRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class OfficerService implements UserDetailsService {

    private final ApplicationUserRepo applicationUserRepo;

    @PersistenceContext
    private EntityManager manager;


    public OfficerService(ApplicationUserRepo applicationUserRepo) {
        this.applicationUserRepo = applicationUserRepo;
    }

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Officer officer = applicationUserRepo.findAllByUsername(username);
       if (username == null) {
           throw new UsernameNotFoundException("User not found");
       }
       return new Officer();
   }
}