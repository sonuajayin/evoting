package in.ajaykumarsingh.evoting.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import in.ajaykumarsingh.evoting.models.User;
import in.ajaykumarsingh.evoting.repositories.UserRepository;

@Service
public class UserAuthService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	public org.springframework.security.core.userdetails.User loadUserByUsername(String email) {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new NullPointerException("No user found with username: " + email);
		}
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword().toLowerCase(),
				enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities(user.getRole()));
	}

	private static List<GrantedAuthority> getAuthorities(String role) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}
}
