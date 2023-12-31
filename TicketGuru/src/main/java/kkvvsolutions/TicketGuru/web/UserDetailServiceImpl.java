package kkvvsolutions.TicketGuru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kkvvsolutions.TicketGuru.domain.AppUser;
import kkvvsolutions.TicketGuru.domain.repository.AppUserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	private final AppUserRepository repository;

	@Autowired
	public UserDetailServiceImpl(AppUserRepository userRepository) {
		this.repository = userRepository;
	}

	// This method is used by Spring Security to authenticate users
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser curruser = repository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(),
				AuthorityUtils.createAuthorityList(curruser.getRole()));
		return user;
	}
}
